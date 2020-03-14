import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
//import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';

// const routes: Routes = [  
//   {  
//     path: 'books',  
//     component: BooksComponent  
//   }
// ];  

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    UserComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  //exports: [RouterModule]  
})
export class AppModule { }
//export class AppRoutingModule { } 
