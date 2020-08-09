import React from 'react';
import {Form, Row, Col, InputGroup, FormControl, Button} from 'react-bootstrap';
import {Person, Lock} from 'react-bootstrap-icons';
import {useDispatch} from 'react-redux';
import { useHistory } from "react-router-dom";
import '../../styles/Main.css';

function LoginForm() {
    const dispatch = useDispatch();

    const history = useHistory();

    const routeChange = () =>{ 
      let path = '/profile'; 
      history.push(path);
    }

    return(
        <Form inline className="login-form text-center">
            <Row className="login-form-row">
                <Col xs={12} md={5} className="responsive-margin">
                    <InputGroup>
                        <InputGroup.Prepend>
                            <InputGroup.Text id="basic-addon1"><Person/></InputGroup.Text>
                        </InputGroup.Prepend>

                        <FormControl
                            placeholder="Username"
                            aria-label="Username"
                            aria-describedby="formBasicUsername"
                        />
                    </InputGroup>
                </Col>

                <Col xs={12} md={5} className="login-responsive">
                    <InputGroup>
                    <InputGroup.Prepend>
                        <InputGroup.Text id="basic-addon1"><Lock/></InputGroup.Text>
                    </InputGroup.Prepend>

                    <FormControl
                        type="password"
                        placeholder="Password"
                        aria-label="Password"
                        aria-describedby="formBasicPassword"
                    />

                    <Row className="w-100"></Row>

                    <Form.Text>
                        <Button variant="secondary" className="button-reset" onClick={() => dispatch({ type: 'SWITCH_FORGOT_REGISTER' })}>Forgot password?</Button>
                    </Form.Text>
                </InputGroup>
                </Col>

                <Col xs={12} md={2} className="login-responsive button-responsive">
                    <Button variant="dark" type="submit" onClick={routeChange}>Login</Button>
                </Col>
            </Row>
        </Form>
    );
}

export default LoginForm;