var websocket = {
		stompClient: null,
		token: null,
		type: null,
		chatId: null
};

function connect(token, type, chatId, fn) {
	websocket.token = token;
	websocket.type = type;
	websocket.chatId = chatId;
	var socket = new SockJS('http://localhost:8080/websocket');
	websocket.stompClient = Stomp.over(socket);
	websocket.stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        websocket.stompClient.subscribe('/topic/chats.'+type+chatId, function(obj) {
        	fn(JSON.parse(obj.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
    	websocket.stompClient.disconnect();
    }
    console.log("Disconnected");
}

function sendContent(content) {
	var query = {}
	query.token = websocket.token;
	query.type = websocket.type;
	query.chatId = websocket.chatId;
	query.content = content;
	websocket.stompClient.send("/app/chats", {}, JSON.stringify(query));
}