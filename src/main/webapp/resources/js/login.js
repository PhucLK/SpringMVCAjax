$(document).ready(function () {

	// check if checkbox is checked then create cookie, else remove cookie
	$('#form-login').submit(function () {
		var expires_day = 1;
		if ($('#remember-me').is(':checked')) {
			$.cookie('username', $('#username').val(), {
				expires: expires_day
			});
			$.cookie('password', $('#password').val(), {
				expires: expires_day
			});
			$.cookie('remember', true, {
				expires: expires_day
			});
		} else {
			// reset cookies, uncheck checkbox
			$.cookie('username', '');
			$.cookie('password', '');
			$.cookie('remember', false);
		}
		return true;
	});
});

$(document).ready(function () {
	// read cookie, if exist cookie -> check ,else uncheck
	var remember = $.cookie('remember');
	if (remember) {
		$('#username').val($.cookie('username'));
		$('#password').val($.cookie('password'));
		$('#remember-me').attr("checked", true);
	} else {
		$('#username').val('');
		$('#password').val('');
		$('#remember-me').attr("checked", false);
	}
});