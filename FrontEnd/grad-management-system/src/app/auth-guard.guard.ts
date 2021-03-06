import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardGuard implements CanActivate {
  constructor( private router: Router) {}
  canActivate(
    route: ActivatedRouteSnapshot,
   
    state: RouterStateSnapshot): boolean {
      //Auth n Authoriazation code here
      //calling a user service pass user mand make sure user is correct

      if (localStorage.getItem('idToken')){
        return true;
      }
      this.router.navigate(['']);
      return false;  
  }
  
}
