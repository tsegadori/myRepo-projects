import React, { Component } from "react";
import './SignupConfirmationCSS.css';



class SignupConfirmation extends Component{

    constructor(props){
        super(props)

    }

    render(){
        return(
            <div className="container">
                <div className="container-style">
                <p><h5>Success!</h5></p>
                <p>Thank you,
                You are successfuly signed up! You will have 7 days free pass to our fitness center. 
                <p>Please visit us.
                    If you have any inquiries, please call help desk at (555)-555-5555 or email xyz@xtremefitness.com.</p>
                </p>
                </div>
            </div>
        )
    }
}

export default SignupConfirmation;