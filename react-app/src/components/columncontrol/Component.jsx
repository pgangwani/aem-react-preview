// Would move this component to react compoennt as it's matured
import React, { useMemo } from 'react';
import PropTypes from 'prop-types';
import { ColumnWrapper, RowWrapper, Grid } from './style';



const ColumnControl = ({
    children,
    desktopColumnsArray,
    tabletColumnsArray,
    mobileColumnsArray,
    horizontalPadding
}) => {
    const renderArrayBasedColumns = useMemo(() => {
        const columnNodes = [];
        const modifiedDesktopColumnsArray = desktopColumnsArray.split(',').map((item) => item.trim());
        const modifiedTabletColumnsArray = tabletColumnsArray.split(',').map((item) => item.trim());
        const modifiedMobileColumnsArray = mobileColumnsArray.split(',').map((item) => item.trim());

        children.forEach((child, index) => {
            const desktopColNumber = 
                Number(modifiedDesktopColumnsArray[index % modifiedDesktopColumnsArray.length]);
            const tabletColNumber = 
                Number(modifiedTabletColumnsArray[index % modifiedTabletColumnsArray.length]);
            const mobileColNumber = 
                Number(modifiedMobileColumnsArray[index % modifiedMobileColumnsArray.length]);
            return (
                columnNodes.push(
                    <ColumnWrapper 
                        horizontalPadding= { horizontalPadding } 
                        sm={ mobileColNumber } 
                        lg={ desktopColNumber } 
                        md = { tabletColNumber }>
                        {child}
                    </ColumnWrapper>
                ));
        });
        return columnNodes;
    }, [desktopColumnsArray, tabletColumnsArray, mobileColumnsArray, children, horizontalPadding]);

    if (children.length === 0) return null;

    const columnNodes = 
        (desktopColumnsArray || tabletColumnsArray || mobileColumnsArray) 
            && renderArrayBasedColumns;

    const gridNode = (
        <Grid>
            <RowWrapper>
                {columnNodes}
            </RowWrapper>
        </Grid>
    );
    return gridNode;
};

ColumnControl.propTypes = {
    children: PropTypes.node,
    desktopColumnsArray: PropTypes.string,
    tabletColumnsArray: PropTypes.string,
    mobileColumnsArray: PropTypes.string,
    horizontalPadding: PropTypes.bool
};

ColumnControl.defaultProps = {
    children: [],
    desktopColumnsArray: '',
    tabletColumnsArray: '',
    mobileColumnsArray: '',
    horizontalPadding: false
};

export default ColumnControl;
