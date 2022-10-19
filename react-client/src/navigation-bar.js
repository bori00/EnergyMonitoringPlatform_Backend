import React, {useState, useEffect} from 'react'
import { DropdownItem, DropdownMenu, DropdownToggle, Nav, Navbar, NavbarBrand, NavLink, UncontrolledDropdown } from 'reactstrap';

import logo from './commons/images/logo.jpg';
import * as API_AUTH from "./commons/authentication/auth-api";

const textStyle = {
    color: 'white',
    textDecoration: 'none'
};

function NavigationBar() {
    const [userRole, setUserRole] = useState(null);

    useEffect(() => {
        setUserRole(API_AUTH.getCurrentUserRole());
        console.log("UserRole: ", userRole)
    });

    return (
        <div>
            <Navbar color="dark" light expand="md">
                <NavbarBrand href="/">
                    <img src={logo} width={"50"}
                        height={"50"} />
                </NavbarBrand>
                <Nav className="mr-auto" navbar>

                    {
                        userRole === 'ADMIN' &&
                        <UncontrolledDropdown nav inNavbar>
                            <DropdownToggle style={textStyle} nav caret>
                                Admin Menu
                            </DropdownToggle>
                            <DropdownMenu right>

                                {/*<DropdownItem>*/}
                                {/*    <NavLink href="/person">Persons</NavLink>*/}
                                {/*</DropdownItem>*/}


                            </DropdownMenu>

                        </UncontrolledDropdown>
                    }

                    {
                        userRole === 'CLIENT' &&
                        <UncontrolledDropdown nav inNavbar>
                            <DropdownToggle style={textStyle} nav caret>
                                Client Menu
                            </DropdownToggle>
                            <DropdownMenu right>

                                {/*<DropdownItem>*/}
                                {/*    <NavLink href="/person">Persons</NavLink>*/}
                                {/*</DropdownItem>*/}


                            </DropdownMenu>

                        </UncontrolledDropdown>
                    }

                    {
                        userRole === null &&
                        <UncontrolledDropdown nav inNavbar>
                            <DropdownToggle style={textStyle} nav caret>
                                Account
                            </DropdownToggle>
                            <DropdownMenu right>

                                <DropdownItem>
                                    <NavLink href="/login">Login</NavLink>
                                </DropdownItem>


                            </DropdownMenu>

                        </UncontrolledDropdown>
                    }

                </Nav>
            </Navbar>
        </div>
    );
}

export default NavigationBar;
