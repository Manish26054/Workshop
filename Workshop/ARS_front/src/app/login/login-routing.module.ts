import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './component/register/register.component';

import { LoginComponent } from './login.component';

const routes: Routes = [{ path: '', component: LoginComponent },
{
  path: 'adminHome',
  loadChildren: () => import('../admin-home/admin-home.module').then(m => m.AdminHomeModule)
},
{ 
  path: 'userHome', 
  loadChildren: () => import('../user-home/user-home.module').then(m => m.UserHomeModule) 
},
{ path: 'login', component: LoginComponent },
{ path: 'register', component: RegisterComponent},

// otherwise redirect to home
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
