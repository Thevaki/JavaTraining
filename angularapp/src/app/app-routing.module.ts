import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BooksComponent } from './books/books.component';
import { LoginComponent } from './login/login.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddBookComponent } from './add-book/add-book.component';

const routes: Routes = [
  {
    path: 'books',    
    component: BooksComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path: 'book-detail',    
    component: BookDetailComponent
  },
  {
    path: 'user-registration',    
    component: UserRegistrationComponent
  },
  {
    path: 'admin-home',    
    component: AdminHomeComponent
  },
  {
    path: 'add-book',    
    component: AddBookComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
