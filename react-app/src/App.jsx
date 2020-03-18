// src/App.js

import React from 'react';
import  {
    Page, withModel, Container, ResponsiveGrid
}from '@adobe/cq-react-editable-components';
import { ThemeProvider } from 'styled-components';
import Header from './components/header/Header';
import GlobalCSS from './theme/GlobalCss';
import theme from './theme/theme';
import {
    AppContainer
} from './style';


// This component is the application entry point
class App extends Page {
    render() {
        console.log('cq editable ', Container, ResponsiveGrid, this.childComponents)
        return (
          <AppContainer>
            <GlobalCSS />
            <ThemeProvider theme = { theme }>
                <Header />
            { this.childComponents }
                { this.childPages }
            </ThemeProvider>
          </AppContainer>
        );
    }
}

export default withModel(App);
