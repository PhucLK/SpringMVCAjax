/*
This function called when "Register" button clicked.
*/

$(document).ready(function () {
    $("#register-form").submit(function () {
        console.log("clcik")
        let emailElement = $("#email");
        let userNameElement = $("#userName");
        let passwordElement = $("#password");
        let confirmPasswordElement = $("#repassword");

        // variable to check valid input

        //let message = "Please fill all mandatory fields";

        setBorderColor(emailElement);
        setBorderColor(userNameElement);
        setBorderColor(passwordElement);
        setBorderColor(confirmPasswordElement);

        let email = emailElement.val();

        if (email != "" && !validateEmail(email)) {
            $("#Eerror").text("Email is incorrect format");
            emailElement.css("border-color", "red");
        } else if (passwordElement.val() != ""
            && passwordElement.val().length < 6) {
            $("#Perror").text("Password must be greater than or equals 6 characters");
            passwordElement.css("border-color", "red");
        } else if (passwordElement.val() != confirmPasswordElement.val()) {
            $("#RPerror").text("Confirm password is not match with password");
            confirmPasswordElement.css("border-color", "red");
        }


        // count number of input tags
        let numberOfInput = $("input").length;

        let countNumberValidInput = 0;
        for (let j = 0; j < numberOfInput; j++) {
            // check all input are valid
            let a = document.getElementsByTagName("input")[j].style.borderColor;
            if (a == "green") { //$('input').css('border-color', "green");
                countNumberValidInput++;
            }
        }

        // if all input are valid, set status = true
        if (countNumberValidInput == numberOfInput) {
            message = "";
            return true;
        }

        return false;
    });


});


/*
 * Check valid email.
 */
function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

/*
 * Change border to an element.
 */
function setBorderColor(element) {
    if (element.val() == "" || (element.val() == null)) {
        element.css("border-color", "red");
    } else {
        element.css("border-color", "green");
    }
}