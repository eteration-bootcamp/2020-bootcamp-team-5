import React, {useState} from 'react';
import {Form, Row, Col, InputGroup, FormControl, Button} from 'react-bootstrap';
import {Person, Lock} from 'react-bootstrap-icons';
import {useDispatch} from 'react-redux';
import { useHistory } from "react-router-dom";
import '../../styles/Main.css';
import axios from 'axios';
import {LOGIN_API} from '../../config/api';
import {setToastTitle, setToastContent, showToastBox} from '../../actions';

function LoginForm() {
    const dispatch = useDispatch();
    const [username, setUserName] = useState('');
    const [password, setPassword] = useState('');
    const history = useHistory();

    const routeChange = () =>{ 
      let path = '/notes'; 
      history.push(path);
    }

    function grabUserName(e) {
        setUserName(e.target.value);
    }

    function grabPassword(e) {
        setPassword(e.target.value);
    }

    function login(e) {
        event.preventDefault();

        const userJSON = {
            'username': `${username}`,
            'password': `${password}`,
        }

        axios.post(LOGIN_API, userJSON)
            .then(res => {
                localStorage.setItem("auth", res.data);
                routeChange();
            })
            .catch(error => {
                dispatch(setToastTitle("Error"));
                dispatch(setToastContent("Invalid username or password!"));
                dispatch(showToastBox());
                console.error(error.response);
            });
    }

    return(
        <Form inline onSubmit={login} className="login-form text-center">
            <Row className="login-form-row">
                <Col xs={12} md={5} className="username-responsive">
                    <InputGroup>
                        <InputGroup.Prepend>
                            <InputGroup.Text id="basic-addon1"><Person/></InputGroup.Text>
                        </InputGroup.Prepend>

                        <FormControl
                            placeholder="Username"
                            aria-label="Username"
                            aria-describedby="formBasicUsername"
                            onChange={e => grabUserName(e)}
                        />
                    </InputGroup>
                </Col>

                <Col xs={12} md={5}>
                    <InputGroup>
                        <InputGroup.Prepend>
                            <InputGroup.Text id="basic-addon1"><Lock/></InputGroup.Text>
                        </InputGroup.Prepend>

                        <FormControl
                            type="password"
                            placeholder="Password"
                            aria-label="Password"
                            aria-describedby="formBasicPassword"
                            onChange={e => grabPassword(e)}
                        />

                        <Row className="w-100"></Row>

                        <Form.Text>
                            <Button variant="secondary" className="forgot-password-text" onClick={() => dispatch({ type: 'SWITCH_FORGOT_REGISTER' })}>Forgot password?</Button>
                        </Form.Text>
                    </InputGroup>
                </Col>

                <Col xs={12} md={2} className="login-responsive">
                    <Button variant="dark" type="submit">Login</Button>
                </Col>
            </Row>
        </Form>
    );
}

export default LoginForm;
