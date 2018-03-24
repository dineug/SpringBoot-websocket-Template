$(function() {
	
	// 소켓서버 접속, 정보셋팅, 응답 fn 정의
	connect($('#hiddenToken').val(), 'order', '1', function(obj){
		var message = obj.domain+':'+obj.id+'('+obj.name+')'+' - '+obj.content;
		$('#greetings').append('<tr><td>'+message+'</td></tr>');
		$('#name').val('');
	});
	
	// 메세지 전송
	$('#send').click(function(){
		
		sendContent($('#name').val());
		
	});
	
});