import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardGuard } from './auth-guard.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { LogsComponent } from './logs/logs.component';
import { SearchComponent } from './search/search.component';
import { TrendsComponent } from './trends/trends.component';

const routes: Routes = [
{path: 'dashboard',
component:DashboardComponent,
children:[
  {path:'',component:SearchComponent},
  {path:'trends',component:TrendsComponent},
  {path:'logs',component:LogsComponent},
]
,
canActivate:[AuthGuardGuard]


},
{path: '',component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents=[
  LoginComponent,
  DashboardComponent,
  SearchComponent,
  TrendsComponent,
  LogsComponent
]