
$('document').ready(function () {
    var pasword = document.getElementById("password");
    var confirmPassword = document.getElementById("confirmPassword");

    function validatePassword() {
        if (password.value !== confirmPassword.value) {
            confirmPassword.setCustomValidity("Password Don't Match");
        }
        else
        {
            confirmPassword.setCustomValidity('');
        }
    }
    pasword.onchange = validatePassword;
    confirmPassword.onkeyup = validatePassword;
});