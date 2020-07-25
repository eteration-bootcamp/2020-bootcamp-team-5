import React from 'react';
import { useHistory } from "react-router-dom";
import {Form, Button, Navbar, Nav} from 'react-bootstrap';

const Navigation = () => {

  const history = useHistory();

  const routeLogin = () =>{ 
    let path = '/login'; 
    history.push(path);
  }

  return (
    <>
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="/">Noteration</Navbar.Brand>
            <Nav className="mr-auto">
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
            </Nav>
            <Form inline>
            <Button variant="outline-info" onClick={routeLogin}>Login</Button>
            </Form>
        </Navbar>
    </>
  )
};

export default Navigation;
