import React, { Component } from 'react';
import styled from 'styled-components';

const HeaderWrapper = styled.header`
background: grey;
line-height: 100px;
margin-bottom: 10px;
`

// eslint-disable-next-line react/prefer-stateless-function
export default class Header extends Component {
    render() {
        return (
            <HeaderWrapper>
                I am non-editable Header
            </HeaderWrapper>
        );
    }
}
