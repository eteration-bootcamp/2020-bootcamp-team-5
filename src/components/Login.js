import React, { Fragment } from 'react';
import ReactDOM from 'react-dom';
import { useHistory } from "react-router-dom";
import {Form, Button} from 'react-bootstrap';
import Navigation from './Navigation';
import '../styles/Login.css';

const Login = () => {
  const history = useHistory();

  const routeChange = () =>{ 
    let path = '/profile'; 
    history.push(path);
  }

  return (
    <Fragment>
      <Navigation/>
      <Form>
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
        <Button variant="primary" type="submit" onClick={routeChange}>
          Submit
        </Button>
      </Form>
    </Fragment>
  )
};

export default Login;
