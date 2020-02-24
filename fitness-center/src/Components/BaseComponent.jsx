import React, {Component} from 'react';
import '../Components/BaseCSS.css';
import { Formik, Form, Field } from 'formik';
 
 
class BaseComponent extends Component{

    constructor(props){

        super(props);

        this.state = {
            firstName: "John Doe",
            lastName: "",
            location: "",
            phone: ""
          }

        this.signupForm = this.signupForm.bind(this)
        this.mypush = this.mypush.bind(this)

    }

    signupForm(values){
        // this.props.signupInfo(values.firstName, values.lastName, values.location, values.phone);
       this.mypush(values)
    }

    mypush(values){
         this.props.history.push('/signup') 
    }

    render(){

        let firstName = this.state.firstName;
        let lastName = this.state.lastName;
        let location = this.state.location;
        let phone = this.state.phone;

        return(
            <div className="">
                <div className="row border-style">
                <div id="carouselExampleControls" className="carousel slide" data-ride="carousel">
                        <div className="carousel-inner image">
                            <div className="carousel-item active">
                            <img className="d-block w-100" src="fitness1.jpg" alt="First slide"/>
                            </div>
                            <div className="carousel-item">
                            <img className="d-block w-100 " src="fitness2.jpg" alt="Second slide"/>
                            </div>
                        </div>
                        <a className="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span className="sr-only">Previous</span>
                        </a>
                        <a className="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span className="carousel-control-next-icon" aria-hidden="true"></span>
                            <span className="sr-only">Next</span>
                        </a>
                        </div>
                </div>
            <div className="section-style border-style">
                <div className="row ">
                        <div className="membership-style"><h3>GET YOUR 7 DAY VIP MEMBERSHIP</h3></div>
                        <div className="container">
                            <img src="threads.jpg" alt="Threds pic" style={{width: "100%"}}></img>
                        </div>
                </div>
                <div className="row">
                    <div className="col-md-6 signup-style">
                        <div className="container">
                            <h6><p>Sign up today and get 7 days to see what it's like</p></h6>
                        </div>
                        <div className="container">
                            <Formik initialValues={{firstName: firstName, lastName: lastName, 
                            location: location, phone: phone}} 
                            onSubmit={this.signupForm}>
                                    {
                                        (props) => (
                                            <Form>
                                                <fieldset className="form-group">
                                                    <label>First name *</label>
                                                    <Field className="form-control" type="text" name="firstName">
                                                    </Field>
                                                </fieldset>
                                                <fieldset className="form-group">
                                                    <label>Last name *</label>
                                                    <Field className="form-control" type="text" name="lastName">
                                                    </Field>
                                                </fieldset>
                                                <fieldset className="form-group">
                                                    <label>Location *</label>
                                                    <Field className="form-control" type="text" name="location">
                                                    </Field>
                                                </fieldset>
                                                <fieldset className="form-group">
                                                    <label>Phone *</label>
                                                    <Field className="form-control" type="text" name="phone">
                                                    </Field>
                                                </fieldset>
                                                <input type="submit" ></input>
                                            </Form>
                                        )
                                    }
                            </Formik>
                        </div>
                                <div> {this.props.firstName}</div>
                    </div>
                    <div className="col-md-3 location-style" style={{marginTop: "6%"}}>
                        <p>Locations</p>
                        
                            <iframe className="iframe-style" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3108.1238586134164!2d-77.11304038472149!3d38.82962415854136!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89b7b3dc547bab95%3A0xab37103d3ad676be!2s4641%20Kenmore%20Ave%2C%20Alexandria%2C%20VA%2022304!5e0!3m2!1sen!2sus!4v1582162244632!5m2!1sen!2sus" 
                               alt="Location-map" style={{width: "400", height: "600", frameborder: "0", allowfullscreen: ""}}>
                            </iframe>    
                    </div>
                    <div className="col-md-3 " style={{marginTop: "6%"}}>
                            <div className="container" style={{width: "100%"}}>
                                <address>
                                    <p className="location-style"><strong>New York</strong></p>
                                    <small>123 NY Ave, New York, NY</small>
                                </address>
                                <br></br>
                                <address>
                                    <p className="location-style"><strong>Washington, DC</strong></p>
                                    <small>55 M St. Washington, DC</small>
                                </address>
                                <address>
                                    <p className="location-style"><strong>Hours</strong></p>
                                    <small>Mon - Fri: 4 a.m. - 12 a.m.</small>
                                    <small>Sat: 6 a.m. - 12 a.m.</small>
                                    <small>Sun: 6 a.m. - 10 p.m.</small>
                                </address>
                            </div>
                    </div>
                </div>
                <div className="container" style={{width: "100%"}}>
                    <h5><p style={{textAlign: "center", paddingTop: "5%", paddingBottom: "3%"}}>What members are saying</p></h5>
                <div className="row"  >
                    
                    <div className="col-md-4">
                        <div className="container">
                            <img className="member-img-style" src="member1.jpg" alt="member's picture"></img>
                            <div>
                                <p><small>"The group classes at Finesse are so much fun, I forget I'm working out! 
                                    Time flies because of the great music and enthusiastic teachers."</small></p>
                                    <p style={{fontWeight: "bold", fontSize: "0.8rem"}}>- Vanessa </p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div className="container ">
                            <img className="member-img-style" src="member2.jpg" alt="member's picture"></img>
                            <div>
                                <p><small>"Finesse has all the equipment i need to get a great workout in without
                                    all the fluff. I do'nt need a smoothie stattion - I just need great machines."</small></p>
                                    <p style={{fontWeight: "bold", fontSize: "0.8rem"}}>- Orlando</p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-4">
                        <div className="container">
                            <img className="member-img-style" src="member3.jpg" alt="member's picture"></img>
                            <div>
                                <p><small>"My favorite thing about Finesse is the flexiblity. Because they're 24 hours, I can come when it's convenient 
                                    for me. As a bartender, that's great!"</small></p>
                                    <p style={{fontWeight: "bold", fontSize: "0.8rem"}}>- Karen</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="row last-sec-style">
                    <div className="col-md-6">
                        <h5>Professional Trainers Ready to Help</h5>
                            <p><small>
                                A great way to speed up your results and focus your workouts is to work with a personal trainer. 
                            Our professional staff has years of experiance working with all kinds of clients.</small>
                            </p>                            
                            <p><small>
                                Studies show that working with a trainer helps people stay motivated and achieve their goals faster. 
                            Whether you're just not sure what to do on the gym floor or simply need someone to be accountablr to, 
                            training is right for you!</small>
                            </p>
                            <p><small>
                                We offer flexible prcing and workout scheduled so training is within reach for everyone. Stop by
                                the front desk today and ask for your free consultation with one of our fitness professionals.</small>
                            </p>
                    </div>
                    <div className="col-md-6">
                            <img src="fitness2.jpg" alt="Fitness Instructor" style={{height: "100%", width: "100%"}}></img>
                    </div>
                </div>
                </div>
                </div>
            </div>
        )
    }
}

export default BaseComponent;