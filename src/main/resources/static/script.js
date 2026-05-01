
function togglePassword(id) {
   const input = document.getElementById(id);
   if (input.type === "password") {
       input.type = "text";
   } else {
       input.type = "password";
   }
}

function validateSignupForm() {
   const username = document.forms["signupForm"]["username"].value;
   const password = document.forms["signupForm"]["password"].value;

   if (username.trim() === ""  || password.trim() === "") {
       alert("All fields are required.");
       return false;
   }

   if (password.length < 6) {
       alert("Password should be at least 6 characters.");
       return false;
   }

   return true;
}
