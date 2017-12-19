class PostalAddressItem extends React.Component {
    constructor(props) {
        super (props);
        this.state = {
            addressLine1: "",
            addressLine2: "",
            city: "",
            state: "",
            postalCode: "",
            country: ""
        }

        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({[name]: value});
    }

    render() {
        return (
            <div>
                <input name = 'addressLine1' type='text' placeholder='Address line 1' value={this.state.addressLine1} onChange={this.handleChange} />
                <input name = 'addressLine2' type='text' placeholder='Address line 2' value={this.state.addressLine2} onChange={this.handleChange} />
                <input name = 'city' type='text' placeholder='City / Provence / Region' value={this.state.city} onChange={this.handleChange} />
                <input name = 'state' type='text' placeholder='State' value={this.state.state} onChange={this.handleChange} />
                <input name = 'postalCode'  placeholder='ZIP / Postal Code' type='text' value={this.state.postalCode} onChange={this.handleChange} />
                <input name = 'country' type='text' placeholder='Country' value={this.state.country} onChange={this.handleChange} />
            </div>
        )
    }
}