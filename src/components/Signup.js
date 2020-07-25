import React, { Fragment } from 'react';
import { useHistory } from "react-router-dom";
import {Form, Button, Col} from 'react-bootstrap';
import Navigation from './Navigation';
import '../styles/Signup.css';

const Signup = () => {
  const history = useHistory();

  const routeProfile = () =>{ 
    let path = '/profile'; 
    history.push(path);
  }

  const routeLogin = () =>{ 
    let path = '/login'; 
    history.push(path);
  }

    return (
        <Fragment>
            <Navigation/>
                <Form>
                    <Form.Row>
                        <Col>
                            <Form.Control placeholder="First name" />
                        </Col>
                        <Col>
                            <Form.Control placeholder="Last name" />
                        </Col>
                    </Form.Row>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control type="email" placeholder="Enter email" />
                        <Form.Text className="text-muted">
                            We'll never share your email with anyone else.
                        </Form.Text>
                    </Form.Group>

                    <Form.Group controlId="formBasicPassword">
                        <Form.Label>Password</Form.Label>
                        <Form.Control type="password" placeholder="Password" />
                    </Form.Group>
                    <Form.Group controlId="formBasicCheckbox">
                        <Form.Check type="checkbox" label="Check me out" />
                    </Form.Group>
                    <Button variant="primary" type="submit" onClick={routeProfile}>
                        Submit
                    </Button>
                    Already have an account?
                    <Button variant="primary" type="outline-primary" onClick={routeLogin}>
                        Login
                    </Button>
                </Form>
        </Fragment>
  )
};

export default Signup;
