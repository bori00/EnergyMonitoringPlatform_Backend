import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import NavigationBar from './navigation-bar';
import Home from './home/home';
import PersonContainer from './person/person-container';
import LoginContainer from "./authentication/login-container";
import RegistrationContainer from "./registration/registration-container";
import ErrorPage from './commons/errorhandling/error-page';
import LogoutFunction from "./authentication/logout-container";
import styles from './commons/styles/project-style.css';
import AdminDeviceManagementContainer
    from "./admin-device-management/admin-device-management-container";
import ManageDeviceModal from "./admin-device-management/manage-device-modal";

/*
    Namings: https://reactjs.org/docs/jsx-in-depth.html#html-tags-vs.-react-components
    Should I use hooks?: https://reactjs.org/docs/hooks-faq.html#should-i-use-hooks-classes-or-a-mix-of-both
*/
function App() {
    return (
        <div className={styles.back}>
            <Router>
                <div>
                    <NavigationBar />
                    <Switch>

                        <Route
                            exact
                            path='/'
                            render={() => <Home />}
                        />

                        <Route
                            exact
                            path='/person'
                            render={() => <PersonContainer />}
                        />

                        <Route
                            exact
                            path='/login'
                            render={() => <LoginContainer />}
                        />

                        <Route
                            exact
                            path='/logout'
                            render={() => <LogoutFunction />}
                        />

                        <Route
                            exact
                            path='/register'
                            render={() => <RegistrationContainer />}
                        />

                        <Route
                            exact
                            path='/admin-device-management'
                            render={() => <AdminDeviceManagementContainer />}
                        />

                        {/*Error*/}
                        <Route
                            exact
                            path='/error'
                            render={() => <ErrorPage />}
                        />

                        <Route render={() => <ErrorPage />} />
                    </Switch>
                </div>
            </Router>
        </div>
    );
}

export default App;