$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	
    $('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});

function login() {
	var userId = $('#login_userId').val();
	var pwd = $('#login_pwd').val();
	
	userId = userId.trim();
	pwd = pwd.trim();
	
	if(userId == '' || pwd == ''){
		alert("입력창을 확인해주세요.");
	}else{
		document.getElementById("login-form").submit();
		/*$.ajax({
		    url: "/login",
		    type: "POST",
		    data: {
		    	"userId" : userId,
		    	"pwd" : pwd
		    },
		    success: function(data) {
		    }
		});*/
	}
}

function register() {
	var userId = $('#register_userId').val();
	var pwd = $('#register_pwd').val();
	var name = $('#register_name').val();
	
	userId = userId.trim();
	pwd = pwd.trim();
	name = name.trim();
	
	if(userId == '' || pwd == '' || name == ''){
		alert("입력창을 확인해주세요.");
	}else{
		document.getElementById("register-form").submit();
		/*$.ajax({
		    url: "/member/create",
		    type: "POST",
		    data: {
		    	"userId" : userId,
		    	"pwd" : pwd,
		    	"name" : name
		    },
		    success: function(data) {
		    }
		});*/
	}
}