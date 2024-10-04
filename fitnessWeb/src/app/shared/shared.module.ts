import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DemoNgZorroAntdModule } from '../demongzoroantdmodule';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink, RouterOutlet } from '@angular/router';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    DemoNgZorroAntdModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterLink,
    RouterOutlet,
  ],
  exports: [
    CommonModule,
    DemoNgZorroAntdModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterLink,
    RouterOutlet,
  ],
})
export class SharedModule { }
