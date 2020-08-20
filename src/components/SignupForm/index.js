import React, {useState} from 'react';
import {Form,Row, Col, Button} from 'react-bootstrap';
import '../../styles/Main.css';
import axios from 'axios';
import {SIGNUP_API} from '../../config/api';
import {useDispatch} from 'react-redux';
import {setToastTitle, setToastContent, showToastBox} from '../../actions';

function SignupForm() {
    const dispatch = useDispatch();
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [mail, setMail] = useState('');
    const [number, setNumber] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function grabFirstName(e) {
        setFirstName(e.target.value);
    }

    function grabLastName(e) {
        setLastName(e.target.value);
    }

    function grabMail(e) {
        setMail(e.target.value);
    }

    function grabNumber(e) {
        setNumber(e.target.value);
    }

    function grabUsername(e) {
        setUsername(e.target.value);
    }

    function grabPassword(e) {
        setPassword(e.target.value);
    }

    function signup(e) {
        e.preventDefault();
        
        const userJSON = {
            'name' : `${firstName}`,
            'surname': `${lastName}`,
            'phoneNumber' : `${number}`,
            'mail' : `${mail}`,
            'username' : `${username}`,
            'password' : `${password}`
        }

        axios.post(SIGNUP_API, userJSON)
            .then(res => {
                dispatch(setToastTitle("Status"));
                dispatch(setToastContent("You have successfully signed up! Please check your email adress to activate your account!"));
                dispatch(showToastBox());
            })
            .catch(error => {
                dispatch(setToastTitle("Error"));
                dispatch(setToastContent(error.response.data));
                dispatch(showToastBox());
                console.error(error.response);
            });
    }

    return(
        <div>
            <h1>Create an account</h1>

            <Form onSubmit={signup} className="form-auth-margin-top">
                <Row>
                    <Col className="form-signup-name">
                        <Form.Group controlId="formBasicFirstName">
                            <Form.Control placeholder="First name" onChange={e => grabFirstName(e)}/>
                        </Form.Group>
                    </Col>

                    <Col className="form-signup-last-name">
                        <Form.Group controlId="formBasicLastName">
                            <Form.Control placeholder="Last name" onChange={e => grabLastName(e)}/>
                        </Form.Group>
                    </Col>
                </Row>

                <Form.Group controlId="formBasicEmail">
                    <Form.Control placeholder="Email adress" onChange={e => grabMail(e)}/>
                </Form.Group>

                <Form.Group controlId="formBasicNumber">
                    <Form.Control placeholder="Mobile number" onChange={e => grabNumber(e)}/>
                </Form.Group>

                <Form.Group controlId="formBasicUsername">
                    <Form.Control placeholder="Username" onChange={e => grabUsername(e)}/>
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Control type="password" placeholder="Password" onChange={e => grabPassword(e)}/>
                </Form.Group>
                
                <Button variant="success" type="submit">
                    Sign Up
                </Button>
            </Form>
        </div>
    );
}

export default SignupForm;
