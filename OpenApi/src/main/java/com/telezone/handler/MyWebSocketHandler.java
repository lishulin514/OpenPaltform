package com.telezone.handler;


import com.telezone.config.NettyConfig;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.util.Date;

/**
 * 接收/处理/响应客户端websocket请求的核心业务处理类
 */
public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object>{
	
	Logger log = Logger.getLogger(MyWebSocketHandler.class);

    private WebSocketServerHandshaker handshaker;
    
    //客户端与服务端创建连接的时候调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	Channel channel = ctx.channel();
        NettyConfig.group.add(channel);
        log.debug("客户端与服务端连接开启..");
    }

    //客户端与服务端断开连接的时候调用
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.remove( ctx.channel());
        log.debug("客户端与服务端连接关闭..");
    }

    //服务端接收客户端发送过来的数据结束之后调用
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    //工程出现异常的时候调用
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    //服务端处理客户端websocket请求的核心方法
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
//        //处理客户端向服务端发起http握手请求的业务
        if(msg instanceof FullHttpRequest){
            handHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
        }
//        //处理websocket连接业务
        else if(msg instanceof WebSocketFrame){
            handWebsocketFrame(channelHandlerContext,(WebSocketFrame) msg);
        }
    }

    /**
     * 处理客户端向服务端发起http握手请求的业务
     * @param ctx
     * @param req
     */
    private void handHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req){
        if(!req.decoderResult().isSuccess() || !("websocket".equals(req.headers().get("Upgrade")))){
            sendHttpResponse(ctx,req,new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        //构造握手响应返回，本机测试 写什么无所谓、ws协议消息的接收不受这里控制
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:8888/websocket", null, false);
        handshaker = wsFactory.newHandshaker(req);
        if(handshaker == null){
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        }else{
            handshaker.handshake(ctx.channel(),req);
        }
    }

    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req,
                                  DefaultFullHttpResponse res){
        if(res.status().code() != 200){
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        //服务端向客户端发送数据
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if(res.status().code() != 200){
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * 处理客户端与服务端之前的websocket业务
     * @param ctx
     * @param frame
     */
    private void handWebsocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame){

        //判断是否关闭websocket的指令
        if(frame instanceof CloseWebSocketFrame){
            handshaker.close(ctx.channel(),(CloseWebSocketFrame) frame.retain());
        }
        //判断是否是ping消息
        if(frame instanceof PingWebSocketFrame){
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        //判断是否是二进制消息，如果是二进制消息，抛出异常
        if(!(frame instanceof  TextWebSocketFrame)){
            System.out.println("目前我们不支持二进制消息");
            return;
//            throw new RuntimeException("["+this.getClass().getName()+"]不支持消息");
        }
        //返回应答消息
        //获取客户端向服务端发送的消息   open打开连接 close关闭连接  后面是UserID
        String request = ((TextWebSocketFrame)frame).text();

        System.out.println("服务端收到客户端的消息=====》》》"+request);
        TextWebSocketFrame tws = new TextWebSocketFrame(new Date().toString()+ctx.channel().id()
                +"===>>>" + request);
//        //群发，服务端向每个连接上来的客户端群发消息
       NettyConfig.group.writeAndFlush(tws);
    }

}
