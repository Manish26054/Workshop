import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { MainComponent } from './components/main/main.component';
import { FormsModule } from '@angular/forms';

import { EmployeeDetailComponent } from './components/employee-detail/employee-detail.component';
import { ConvertToSpacePipe } from './pipes/convert-to-space.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    EmployeeDetailComponent,
    ConvertToSpacePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
