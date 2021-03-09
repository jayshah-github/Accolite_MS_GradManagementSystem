import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SocialAuthService } from 'angularx-social-login';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private authService:SocialAuthService,private route:ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
  }

  signOut(): any{
    localStorage.removeItem("idToken")
    this.router.navigate(['']);
    this.authService.signOut();
    // .then(()=>{
    //   localStorage.removeItem("idToken")
    //   this.router.navigate(['']);
    // }, error => {
    //   console.log(error); // Error!
    // });
  }
}