import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticateService } from '../authenticate.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  

  myForm: FormGroup;

  constructor(private fb: FormBuilder, private Authentication:AuthenticateService, private routes:Router) {
    this.myForm = this.fb.group({
      // Define form controls with initial values and validators
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailAddress: ['', [Validators.required, Validators.email]],
    });
  }


  
  submitForm() {
    if (this.myForm.valid) {
      console.log(this.myForm.value);
      const formData = this.myForm.value;
  
      this.Authentication.register(formData).subscribe(
        response => {
          // Check the content type of the response
          const contentType = response.headers.get('Content-Type');
  
          if (contentType && contentType.includes('application/json')) {
            // If the response is JSON, handle it as expected
            console.log('User registered successfully:', response.body);
            this.routes.navigate(['/login']);
          } else {
            // If the response is not JSON, handle it accordingly
            console.error('Unexpected response format. Expected JSON.');
            console.log('Response body:', response.body);
          }
        },
        error => {
          // Handle the error response
          console.error('Error during registration:', error);
  
          if (error instanceof HttpErrorResponse) {
            console.error(`Status: ${error.status}, Status Text: ${error.statusText}`);
            console.log('Response body:', error.error);
          }
  
          // You can add more specific error handling based on your requirements
        }
      );
    }
  }
  
  

}
