# PhotoUpload
A Firebase login and registration app used to upload an image to the firebase storage. 
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Getting Satrted](#getting-started)
* [Creating the project](#creating-the-project)

## General info
This is a simple project which uses Firebase authentication and Firebase storage. It allows user to sign in or register using their email id and password and then upload an image to the Firebase storage. 
	
## Technologies
Project is created with:
* Java
* FireBase
	
## Getting Started
* The project was first connected to Firebase from the Android Studio.
* Firebase Authentication was added to the project
* An account was made on Firebase to gain access to thier console
* On the Firebase console, the sign-in method, email/password was enabled.

## Creating the project
* 4 Activities including the main were used
    * <b>Main</b>
    <br> Main activity gives the user the option to either Login or register which then takes them to SignIn page or SignUp page respectively
    <br> <img src = "https://user-images.githubusercontent.com/58609212/108518920-22b57680-72ef-11eb-991a-f55ad43f90bb.png" width="200" height = "400" />
    * <b>SignUp</b>
    <br> SignUp Activity inputs user's email address and password and on successful registration takes them to upload page.
    <br> <img src = "https://user-images.githubusercontent.com/58609212/108520348-9441f480-72f0-11eb-87ba-96b5ddd68d2a.png" width = "200" height = "400" />
    * <b>SignIn</b>
    <br> SignIn Activity inputs user's email address and password and on succeful login takes them to upload page
    <br> <img src = "https://user-images.githubusercontent.com/58609212/108520076-44fbc400-72f0-11eb-8137-6c53ec7a8e33.png" width="200" height="400" />
    * <b>Upload</b>
    <br> Upload activity allows the user top choose an image from the gallery and upload to the firebase storage
    <br> <img src = "https://user-images.githubusercontent.com/58609212/108520463-b5a2e080-72f0-11eb-9f9f-7f95ec205730.png" width = "200" height ="400" />
    
