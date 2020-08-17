import React, { useState } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Switch, Redirect } from "react-router-dom";
import { createStore } from 'redux';
import reducer from './reducers';
import { Provider } from 'react-redux';
import 'bootstrap/dist/css/bootstrap.min.css';
import {AUTH_API} from './config/api';
import axios from 'axios';

import WelcomePage from './containers/WelcomePage';
import NotesPage from './containers/NotesPage';
import PageNotFound from './containers/PageNotFound';

const store = createStore(
  reducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

function auth(setAuthResult) {
  axios.get(AUTH_API, { 'headers': { 'auth': localStorage.getItem('auth') } })
    .then(res => {
      setAuthResult(true);
    })
    .catch(error => { 
      setAuthResult(false);
    });
}

function requireAuth(Page, authResult, setAuthResult) {
  auth(setAuthResult);
  return (authResult ? <Page /> : <Redirect to ="/" />)
}

function homePage(authResult, setAuthResult) {
  auth(setAuthResult);
  return (authResult ? <Redirect to ="/notes" /> : <WelcomePage />)
}

const App = () => {
  const [authResult, setAuthResult] = useState(false);

  return (
    <Router>
      <Switch>
        <Route exact path="/" component={() => homePage(authResult, setAuthResult)} />
        <Route exact path="/notes" component={() => requireAuth(NotesPage, authResult, setAuthResult)} />
        <Route exact path="*" component={PageNotFound} />
      </Switch>
    </Router>
  );
};

export default App;

const wrapper = document.getElementById("app");
wrapper ? ReactDOM.render(<Provider store={store}><App /></Provider>, wrapper) : false;
