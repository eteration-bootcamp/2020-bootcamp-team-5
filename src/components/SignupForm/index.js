import React from 'react';
import {Form,Row, Col, Button} from 'react-bootstrap';
import { useHistory } from "react-router-dom";
import '../../styles/Main.css';

function SignupForm() {
    const history = useHistory();

    const routeProfile = () =>{ 
      let path = '/profile'; 
      history.push(path);
    }

    return(
        <div>
            <h1>Create an account</h1>

            <Form className="form-auth-margin-top">
                <Row>
                    <Col className="form-signup-name">
                        <Form.Group controlId="formBasicFirstName">
                            <Form.Control placeholder="First name" />
                        </Form.Group>
                    </Col>

                    <Col className="form-signup-last-name">
                        <Form.Group controlId="formBasicLastName">
                            <Form.Control placeholder="Last name" />
                        </Form.Group>
                    </Col>
                </Row>

                <Form.Group controlId="formBasicEmail">
                    <Form.Control placeholder="Email adress" />
                </Form.Group>

                <Form.Group controlId="formBasicNumber">
                    <Form.Control placeholder="Mobile number" />
                </Form.Group>

                <Form.Group controlId="formBasicUsername">
                    <Form.Control placeholder="Username" />
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Control type="password" placeholder="Password" />
                </Form.Group>
                
                <Button variant="success" type="submit" onClick={routeProfile}>
                    Sign Up
                </Button>
            </Form>
        </div>
    );
}

export default SignupForm;
