/* eslint-disable no-underscore-dangle */
import { createStore, combineReducers } from 'redux';


const rootReducer = combineReducers({
    api: (state = {}) => state,
});

const preloadedState = {
};
// eslint-disable-next-line no-underscore-dangle
// const composeEnhancers = preloadedState.env === 'development'
//     ? (typeof window !== 'undefined' && window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__)
// || compose : compose;
const storeWithSelectedStore = createStore(rootReducer, preloadedState,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

export default storeWithSelectedStore;

export {
    storeWithSelectedStore
};
