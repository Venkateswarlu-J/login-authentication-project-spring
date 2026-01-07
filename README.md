project:

  title: "🔐 **Spring Boot Authentication (SecAuth)**"

  description: >
    A _backend-focused Spring Boot application_ that implements a **secure
    user authentication system** with **OTP-based password reset**, session
    handling, and email verification.


overview:

  summary: >
    This project simulates **real-world authentication workflows** using
    **Spring Boot**. It focuses on _backend logic_, **security flow**, and
    **Spring framework concepts** rather than frontend UI complexity.

  scope:
    - "🧑‍💻 **User Registration**"
    
    - "🔐 **Login & Logout**"
    
    - "🔢 **OTP-based Verification**"
    
    - "🔁 **Password Reset**"
    
    - "🗂️ **Session Management**"


purpose:

  objectives:
  
    - "🚀 **Practice Spring Boot backend development**"
    
    - "🏗️ **Understand Spring MVC architecture**"
    
    - "🔒 **Implement authentication & authorization workflows**"
    
    - "⏱️ _Learn OTP generation, validation, and expiry handling_"
    
    - "🧠 _Work with HTTP session management_"

    - "🛠️ _Improve debugging and project structuring skills_"
    


tech_stack:

  backend:
  
    - "☕ **Java**"
    
    - "🌱 **Spring Boot**"
    
    - "🧩 **Spring MVC**"
    

  frontend:
  
    - "🌐 HTML"
    
    - "🎨 CSS"
    
    - "⚙️ JavaScript"
    

  tools:
  
    - "📦 Maven"
    
    - "🗂️ HTTP Sessions"
    
    - "📧 SMTP Email Service"
    


application_flow:

  - step: "🧑‍💻 **User Registration**"
  - 
    description:
      - "User submits registration details"

  - step: "🔐 **User Login**"
  - 
    description:
      - "User enters email and password"
      - "Credentials verified from database"

  - step: "🚪 **Logout**"
    description:
      - "User initiates logout"

  - step: "🔑 **Forgot Password**"
    description:
      - "User submits registered email"
      - "Backend verifies email existence"
      - "**OTP generated**"
      - "_OTP and expiry stored in HTTP session_"
      - "OTP sent via email"

  - step: "🔢 **OTP Verification**"
    description:
      - "User submits OTP"

  - step: "🔁 **Password Reset**"
    description:
      - "User enters new password"
      - "**Password updated in database**"

learning_outcomes:
  - "📚 **Strong understanding of Spring Boot authentication flow**"
  - "🗂️ Hands-on experience with **HTTP session management**"

  - "🔐 **OTP security implementation**"
  -"🐞 Backend debugging techniques

  - "🏗️ Real-world **Spring MVC project structuring**"

