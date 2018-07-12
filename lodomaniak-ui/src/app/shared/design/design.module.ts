import {NgModule} from "@angular/core";
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule, MatDialogModule, MatDividerModule,
  MatFormFieldModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule, MatSelectModule,
  MatSidenavModule,
  MatSnackBarModule,
  MatToolbarModule
} from "@angular/material";

@NgModule({
  imports: [
    MatButtonModule,
    MatDividerModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSidenavModule,
    MatCheckboxModule,
    MatSnackBarModule,
    MatSelectModule,
    MatListModule
  ],
  exports: [
    MatButtonModule,
    MatDividerModule,
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSidenavModule,
    MatCheckboxModule,
    MatSnackBarModule,
    MatSelectModule,
    MatListModule
  ]
})
export class DesignModule {

}
