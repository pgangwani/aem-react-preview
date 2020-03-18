// src/index.js

import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { ModelManager, Constants } from '@adobe/cq-spa-page-model-manager';
import App from './App';
// include Mapped Components
import './components/MappedComponents';

import { storeWithSelectedStore } from './Store';

// eslint-disable-next-line no-underscore-dangle
window.__SERVER__ = false;

if (!window.Lowes) {
    window.Lowes = {};
}

const store = storeWithSelectedStore;

window.store = store;

function render(model) {
    ReactDOM.render((
        <Provider store={ store }>
            <App
                cqChildren={ model[Constants.CHILDREN_PROP] }
                cqItems={ model[Constants.ITEMS_PROP] }
                cqItemsOrder={ model[Constants.ITEMS_ORDER_PROP] }
                cqPath={ ModelManager.rootPath } locationPathname={ window.location.pathname }
            />
        </Provider>
    ), document.getElementById('root'));
}

ModelManager.initialize({ path: process.env.REACT_APP_PAGE_MODEL_PATH }).then(render);
