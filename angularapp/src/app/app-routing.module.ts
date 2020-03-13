import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BooksComponent } from './books/books.component';
//import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';


// const routes: Routes = [
//   {
//     path: '',    
//     component: AppComponent,
//     children: [
//       { path: 'books', loadChildren: './books/books.component' }
//       //{ path: 'drivers', loadChildren: './drivers/drivers.module#DriversModule' },
// //  },
//     ]}
// ];

const routes: Routes = [
  {
    path: 'books',    
    component: BooksComponent
  },
  {
    path:'login',
    component:LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
