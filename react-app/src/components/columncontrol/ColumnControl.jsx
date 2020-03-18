/* eslint-disable react/prefer-stateless-function */
import React, { Component } from 'react';
import { MapTo, withComponentMappingContext } from '@adobe/cq-react-editable-components';
import ColumnControl from "./Component";

/**
* Default EditConfig configuration for the Slimpopcat component
* that interact with the Core Image component and sub-types
*
* @type EditConfig
*/
const ColumnControlEditConfig = {

    emptyLabel: 'ColumnControl',

    isEmpty(props) {
        return !props || !(props.columnsArray);
    }
};

class ColumnControlWrapper extends Component {
    render() {
        console.log('DEBUG', this );
        return(<div {...this.containerProps}>
            <ColumnControl {...this.props}>
                {/* I want parsys or 'drag components' experience here like in app.jsx */}
                { this.childComponents }
            </ColumnControl>
        </div>);
    }
}

MapTo('wknd-events/components/content/columncontrol')(withComponentMappingContext(ColumnControlWrapper), ColumnControlEditConfig);
