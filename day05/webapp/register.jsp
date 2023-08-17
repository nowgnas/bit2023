<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container" style="margin-top:30px">
  <div class="row">

    <div class="col-sm-12">
      <form action="/index.jsp" class="needs-validation" novalidate>
        <div class="form-group">
          <label for="uname">Username:</label>
          <input type="text" class="form-control" id="uname" placeholder="Enter username"
                 name="uname" required>
          <div class="valid-feedback">Valid.</div>
          <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
          <label for="pwd">Password:</label>
          <input type="password" class="form-control" id="pwd" placeholder="Enter password"
                 name="pswd" required>
          <div class="valid-feedback">Valid.</div>
          <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group form-check">
          <label class="form-check-label">
            <input class="form-check-input" type="checkbox" name="remember" required> I agree on
            blabla.
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Check this checkbox to continue.</div>
          </label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>

      <script>
        // Disable form submissions if there are invalid fields
        (function () {
          'use strict';
          window.addEventListener('load', function () {
            // Get the forms we want to add validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
              form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }
                form.classList.add('was-validated');
              }, false);
            });
          }, false);
        })();
      </script>
    </div>

  </div>
</div>