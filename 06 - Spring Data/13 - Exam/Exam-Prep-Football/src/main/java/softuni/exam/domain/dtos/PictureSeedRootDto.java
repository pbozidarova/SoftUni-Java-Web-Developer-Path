package softuni.exam.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PictureSeedRootDto {

    @XmlElement(name = "picture")
    List<PictureSeedDto> pictures;

    @NotNull
    public List<PictureSeedDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureSeedDto> pictures) {
        this.pictures = pictures;
    }
}
