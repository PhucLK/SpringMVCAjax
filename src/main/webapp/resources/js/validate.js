$(document).ready(function () {

    //validate form using jquery validate library
    $("#register-form").validate({
        rules: {
            userName: {
                required: true,
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
            },

            repassword: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            }

        },

        message: {
            userName: {
                required: "Please enter username",
            },
            email: {
                required: "Please enter email",
                email: "Please enter a valid email"
            },
            password: {
                required: "Please enter password",
                minlength: "Password must contain at least 5 character"
            },

            repassword: {
                required: "Please enter password",
                minlength: "Password must contain at least 5 character",
                equalTo: "Passwrord not match above "
            }
        }

    });

    $("#form-login").validate({
        rules: {
            userName: {
                required: true,
            },
            password: {
                required: true,
                minlength: 5
            },

        },

        message: {
            userName: {
                required: "Please enter username",
            },
            password: {
                required: "Please enter password",
                minlength: "Password must contain at least 5 character"
            },
        }
    });

});