import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import {Form, FormControl, Button, Navbar, Nav} from 'react-bootstrap';

const Navigation = () => {
  return (
    <>
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#home">Noteration</Navbar.Brand>
            <Nav className="mr-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
            </Nav>
            <Form inline>
            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
            <Button variant="outline-info">Search</Button>
            </Form>
        </Navbar>
    </>
  )
};

export default Navigation;
