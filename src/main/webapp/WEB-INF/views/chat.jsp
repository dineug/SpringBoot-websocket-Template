<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/res/js/jquery-3.2.1.min.js"></script>
    
    <script src="/res/js/sockjs.min.js"></script>
    <script src="/res/js/stomp.min.js"></script>
    <script src="/res/js/chats.js"></script>
    
    <script src="/res/js/main.js"></script>
    
</head>
<body>

<!-- token 정보 -->
<input type="hidden" id="hiddenToken" value="${user.token}">

<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">보낼 메세지</label>
                    <input type="text" id="name" class="form-control" placeholder="보낼 메세지">
                </div>
                <button id="send" class="btn btn-default" type="button">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>