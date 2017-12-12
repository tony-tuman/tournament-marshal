class NavBar extends React.Component {
    constructor (props) {
        super(props);
    }

  render() {
    var menuOptions = [];
    menuOptions.push(this.menuElement(0, {href: '/About'}, 'About'));
    for (let i=0; i < this.props.items.length; i++) {
       menuOptions.push(this.menuElement(i+1, this.props.items[i].nav, this.props.items[i].display))
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

  menuElement(itemKey, nav, display) {
      return React.createElement('li', {key : itemKey},
                 React.createElement('a', {href : nav}, display)
             );
  }

}

NavBar.propTypes = {items: React.PropTypes.array};