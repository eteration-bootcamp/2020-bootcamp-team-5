import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Switch, Redirect } from "react-router-dom";
import { createStore } from 'redux';
import reducer from './reducers';
import { Provider } from 'react-redux';
import 'bootstrap/dist/css/bootstrap.min.css';

import WelcomePage from './containers/WelcomePage';
import NotesPage from './containers/NotesPage';
import PageNotFound from './containers/PageNotFound';

const store = createStore(
  reducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

//TODO add isLoggedIn service from backend.
const auth = () => {
  return localStorage.getItem("auth");
}

const App = () => {
  return (
        <Router>
          <Switch>
            <Route exact path="/" render={() => (auth() ? (<Redirect to="/notes" />) : (<WelcomePage />))} />
            <Route exact path="/notes" render={() => (auth() ? (<NotesPage />) : (<Redirect to="/" />))} />
            <Route exact path="*" component={PageNotFound} />
          </Switch>
        </Router>
  );
};

export default App;

const wrapper = document.getElementById("app");
wrapper ? ReactDOM.render(<Provider store={store}><App /></Provider>, wrapper) : false;
