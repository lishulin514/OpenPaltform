var socket;
var WebSocketObj = {
    init : function(serverUrl){
        if(!window.WebSocket){
            window.WebSocket = window.MozWebSocket;
        }
        if(window.WebSocket){
            socket = new WebSocket(serverUrl);
            socket.onmessage = function (ev) {
                var ta = document.getElementById('responseContent');
                ta.value += event.data + "\r\n";
            };
            socket.onopen = function (ev) {
                var ta = document.getElementById('responseContent');
                ta.value = "成功\r\n";
            };

            socket.onclose = function (ev) {
                var ta = document.getElementById('responseContent');
                ta.value = "";
                ta.value = "WebSocket连接已经关闭 \r\n";
            }
        }else{
            alert("您的浏览器不支持WebSocket");
        }
    },
    send :function (message){
        if(!window.WebSocket){
            return;
        }
        if(socket.readyState = WebSocket.OPEN){
            socket.send(message);
        }else{
            alert("连接失败");
        }
    }
}
