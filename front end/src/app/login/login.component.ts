import { Component } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm: FormGroup;
  myArray!: string[];
  userData!: string;
  

  constructor(private Authentication:AuthenticateService, private fb: FormBuilder, private router: Router){

    this.loginForm = this.fb.group({
      // Define form controls with initial values and validators
      firstName: ['', Validators.required],
      emailAddress: ['', [Validators.required, Validators.email]],
    });
  }

  logUser() {
    if (this.loginForm.valid) {
      const userEmail = this.loginForm.get('emailAddress')?.value;
  
      console.log(userEmail);  // Log the email address for verification
  
      this.Authentication.login(userEmail).subscribe(
          response => {
            console.log(response);
            if(response == "email Exists and is active"){
              this.router.navigate(['/chat']);
            }
            else{
              console.log(response);
            }
            
          return;
        },
        ); 
      } 
   }  
}