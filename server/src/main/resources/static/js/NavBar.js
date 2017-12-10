var NavBar = React.createClass ({
    propTypes: {
        items: React.PropTypes.array
    },

  render: function() {
    var menuOptions = [];
    for (i=0; i < this.props.items.length; i++) {
       menuOptions.push(React.createElement('li', {key : i},
                            React.createElement('a', {href : this.props.items[i].nav}, this.props.items[i].display)
                            )
                       )
    };

    return (
      React.createElement('div', {className: 'NavBar'},
        React.createElement('div', {className: 'NavWide'},
          React.createElement('ul', {className: 'MyUL'},
                menuOptions
            )
        )
      )
    )
  }
});