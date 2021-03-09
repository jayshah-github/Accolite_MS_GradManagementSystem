import { Component, OnInit } from '@angular/core';
import { SocialAuthService } from "angularx-social-login";
import { FacebookLoginProvider, GoogleLoginProvider } from "angularx-social-login";
import { Router } from '@angular/router';
import { SocialUser } from "angularx-social-login";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: SocialUser | undefined ;

  constructor(private authService: SocialAuthService,private router: Router) { }

  ngOnInit(): void {
    if (localStorage.getItem('idToken')){
      this.router.navigate(['/dashboard']);
    }

    this.authService.authState.subscribe((user)=>{
      this.user=user;

      console.log(user);
    })

      
  }
  signInWithGoogle(): any{
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then((userData)=>{
      localStorage.setItem('idToken', userData.idToken);
      this.router.navigate(['/dashboard']);

    });
  }

  signOut(): any{
    this.authService.signOut().then(()=>{
      localStorage.removeItem('idToken')
      console.log("removed")
    }, error => {
      console.log(error); // Error!
    });
  }

}