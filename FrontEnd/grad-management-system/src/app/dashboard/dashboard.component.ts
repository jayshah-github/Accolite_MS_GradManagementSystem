import { Component, OnInit } from '@angular/core';
import { SocialAuthService } from "angularx-social-login";
import { Router } from '@angular/router';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private authService: SocialAuthService,private router: Router) {  


    
  }

  ngOnInit(): void {
  }

}
