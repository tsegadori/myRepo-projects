import React from 'react';
import {Component} from 'react';
import '../Body/body.css'

class Body extends Component{

    constructor(){
        super()

        this.state={
            btnValue: "Learn more about COVID-19"
        }
    }
    render(){ 

        return(
            <div className="container-fluid">
                <div className="row">
                    <div className="col-md-4">
                        <img id="pic1" className="picture-style" src="pic1.png" alt="family"/>
                    </div>
                    <div className="col-md-8">
                        <div className="paragraph-header">Your health. Our cause.</div>
                        <div className="container-fluid" style={{paddingLeft: '10px', paddingRight: '10px'}}>
                            <p className="paragraph-style">
                                Protecting your health has never been more important. No matter what changes 
                                or challenges lie ahead, we’re here to help you stay safe and healthy. 
                            </p>
                            <div className="d-flex justify-content-end">
                                <a href="#" className="btn-style" type="button" style={{textDecoration: 'none'}}>
                                     Learn more about COVID-19 
                                </a>
                            </div>
                        </div>
                        
                    </div>
                    
                </div>
                <div id="section2" >
                        <div className="row">
                            <div className="col-md-4">
                                <div>
                                    <img className="picture2-style" src="pic2-1.png"></img>
                                </div>
                                 <div  className="pic-titles">
                                     <span className="styling-4 ">Get help with self-care</span>
                                    <p className="paragraph-style">Explore tools and resources to help with stress, depression, sleep, and more.</p>
                                 </div>
                                    
                            </div>
                            <div className="col-md-4">
                                <img className="picture2-style" src="pic2-2.png"></img>
                                <div  className="pic-titles">
                                    <span className="styling-4 ">Connect to care</span>
                                    <p className="paragraph-style">Get the care you need to stay healthy — with or without an in-person visit.</p>
                                </div>
                            </div>
                            <div className="col-md-4">
                                <img className="picture2-style" src="pic2-3.png"></img>
                                <div className="pic-titles">
                                    <span className="styling-4 ">Keep your coverage</span>
                                    <p className="paragraph-style">Find resources that can help you if you lose your health care coverage.</p>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div className="custom-container">
                        <div className="row">
                        <div className="col-md-12">
                            <div className="styling-4">Health care designed to help you thrive</div>
                            <p className="paragraph-style">You deserve health care that’s simple, personalized, and hassle-free. 
                                At Kaiser Permanente, everyone — and everything — works together for one very important cause. You.</p>
                        <div className="d-flex justify-content-start">
                            <a className="btn-style" href="#" type="button">See how we support you</a>
                            <div id="mem1" >
                                <a href="#">New member? Start here.</a>
                            </div>
                        </div>
                        </div>
                    </div>
                    </div>
                    <div className="custom-container">
                            <div className="row">
                            <div className="col-md-6">
                                <div className="sec3-pic">
                                    <img className="section3-pic-style" src="pic3-1.png"></img>
                                </div>
                                <div className="">
                                    <div className="styling-4 sect-margin">Shop our plans</div>
                                    <hr className="hr-blue"></hr>
                                    <p className="paragraph-style">As a Kaiser Permanente member, you get more than just a health plan.</p>
                                </div>
                                <div className="">
                                    <a className="section4-btn"  href="#" type="button">Shop health care plans</a>
                                </div>
                            </div>
                            <div className="col-md-6">
                                <div className="sec3-pic">
                                    <img className="section3-pic-style" src="pic3-2.png"></img>
                                </div>
                                <div className="">
                                    <div className="styling-4 sect-margin">Doctors and locations</div>
                                    <hr className="hr-blue"></hr>
                                    <p className="paragraph-style">You can find top-notch Kaiser Permanente doctors at world-class facilities near you.</p>
                                </div>
                                <div className="">
                                    <a className="section4-btn" href="#" type="button">Find doctors and locations</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="custom-container">
                         <div className="row">
                        <div className="col-md-12">
                            <div className="section-4">
                                <img className="" src="section4-1.png"></img>
                            </div>
                            
                        </div>
                    </div>
                    </div>
                   <div className="custom-container">
                       <div className="row">
                        <div className="col-md-12">
                            <div className="styling-4" style={{color: "black"}}>Specialty care you can trust</div>
                            <p className="paragraph-style">We work hard to keep you healthy. But if you do get sick, we work even harder to help you get well. Collaborating 
                                across specialties enables quicker diagnoses, more efficient treatment, and faster recoveries.</p>
                                <div className="">
                                    <a className="section4-btn"  href="#" type="button" style={{textDecoration: "none"}}>Learn more</a>
                                </div>
                        </div>
                    </div>
                   </div>
                    
            </div>
        )
    }
}

export default Body;
